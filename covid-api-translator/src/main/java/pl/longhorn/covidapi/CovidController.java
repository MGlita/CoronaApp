package pl.longhorn.covidapi;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("covid")
public class CovidController {

    private List<ProvinceModel> provinceModelCache;
    private LocalDateTime lastUpdateProvinceModelCache = LocalDateTime.MIN;

    @GetMapping("province")
    public synchronized List<ProvinceModel> getByProvince() throws UnirestException {
        if(cacheIsOld()){
            regenerateData();
        }
        return provinceModelCache;
    }

    private void regenerateData() throws UnirestException {
        String fileAddress = getFileAddress();
        String csvFile = getCsvFile(fileAddress);
        provinceModelCache = parseData(csvFile);
        lastUpdateProvinceModelCache = LocalDateTime.now();
    }

    private List<ProvinceModel> parseData(String csvFile) {
        return new CsvToBeanBuilder<ProvinceModel>(new StringReader(csvFile))
                .withType(ProvinceModel.class)
                .build()
                .parse();
    }

    private String getCsvFile(String fileAddress) throws UnirestException {
        return Unirest.get(fileAddress).asString().getBody();
    }

    private String getFileAddress() throws UnirestException {
        return Unirest.get("https://opendata.whiteaster.com/v1/resources/556/")
                .asJson()
                .getBody()
                .getObject()
                .get("file")
                .toString();
    }

    private boolean cacheIsOld() {
        return lastUpdateProvinceModelCache.plusMinutes(10).isBefore(LocalDateTime.now());
    }
}

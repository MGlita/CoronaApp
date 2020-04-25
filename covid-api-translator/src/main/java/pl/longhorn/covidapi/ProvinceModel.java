package pl.longhorn.covidapi;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProvinceModel implements Serializable {

    @CsvBindByName(column = "Województwo")
    private String name;

    @CsvBindByName(column = "Chorzy")
    private int confirmedAmount;

    @CsvBindByName(column = "Liczba zgonów")
    private int deadAmount;
}

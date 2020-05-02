<template>
  <div class="home">
    
      <div class="page_content">
        <br>
        <h1><b>CoronaApp </b><br> Najnowsze statystyki zachorowań na COVID-19.</h1>
        <br>
        <hr/>
        <div class="container">
          Rok 2020 rozpoczął się w nieoczekiwany dla nikogo sposób. Pandemia koronowirusa rozprzestrzenia się błyskawicznie, obejmując swoim zasięgime cały świat.
          Dzięki CoronaApp zapoznaj się z najnowszymy statystykami związanymi z zachorowaniami na COVID-19. <br><br>
          <h5>Bądź świadom!</h5> Sprawdź panującą sytuację i  aktualne statystyki zachorowań w <a href="/poland" class="href">Polsce</a> oraz na <a href="/world" class="href">świecie</a>.
        </div>
        <hr/>
        <div class="container">           
          <table class="table borderless">
            <tbody>
              <tr>
                <td colspan=2 class="td">
                  <h3 style="text-align: center">Jakie są główne objawy?</h3>
                    <ul>
                      <li>kaszel</li>
                      <li>gorączka</li>
                      <li>zmęczenie</li>
                      <li>trudności z oddychaniem (w ciężkich przypadkach)</li>
                    </ul>
                    Od zakażenia do pojawienia się objawów może minąć 1–14 dni. Najczęstsze objawy choroby koronawirusowej (COVID-19) to gorączka, zmęczenie i suchy kaszel. Większość ludzi (około 80%) zdrowieje bez potrzeby specjalnego leczenia.
W rzadszych przypadkach choroba ma ciężki przebieg i może nawet być śmiertelna. U osób starszych i mających inne schorzenia (takie jak astma, cukrzyca lub choroby serca), zakażenie koronawirusem może prowadzić do ciężkiej choroby.
                </td>
                <td colspan=2 class="td">
                  <h3 style="text-align: center">Jak zapobiegać zarażeniu?</h3>
                  <ul>
                      <li>Regularnie myj ręce przez 20 sekund mydłem i wodą lub środkiem dezynfekującym na bazie alkoholu.</li>
                      <li>Gdy kaszlesz lub kichasz, zakrywaj usta i nos chusteczką jednorazową lub wewnętrzną stroną łokcia.</li>
                      <li>Unikaj bliskiego (mniej niż 1 metr) kontaktu z osobami, które źle się czują.</li>
                      <li>Jeśli źle się czujesz, nie wychodź z domu i odizoluj się od innych domowników.</li>
                      <li>Nie dotykaj oczu, nosa ani ust, gdy masz brudne ręce.</li>
                    </ul>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    
  </div>
</template>

<script>
</script>
<style>

.home {
    background-color: #dde4f0;
    margin: 0px; 
    padding: 0px;
    min-height: calc(100vh - 3rem);
    }
.page_content {
      background-color: #FFFFFF;
      box-shadow: 0 5px 10px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
      width: 80%;
      margin: 0px; 
      padding: 0px;
      min-height: calc(100vh - 6rem);
      margin-left: 10%;
      margin-right: 10%;
  }
hr {
  border: 2px solid #dde4f0;
  width: 90%;
  margin-left: 5%;
  margin-right: 5%;
  margin-top: 35px;
  margin-bottom: 30px;
}
.container {
  width: 90%;
  margin-left: 5%;
  margin-right: 5%;
}
.borderless td {
	border: none;
}
.table td {
    padding: 20px;
    text-align: justify;
}
table{
  table-layout: fixed;
}
ul {
  text-align: left;
}
.href {
  font-weight: bold;
  color: red;
}
</style>
<template>
  <div class="container2"><br>
    <h1>{{countryName}}</h1><br><br>
    <h2>Całkowita liczba zakażonych: <b>{{casesTotal}}</b></h2><br>
    <canvas class="chart" id="myChart"></canvas>
    <div class="fund"> 
      <h2>Wspomóż walkę z koronawirusem na świecie</h2><br>
      <a href="https://www.who.int/emergencies/diseases/novel-coronavirus-2019/donate">
        <img class="logo" src="https://logos-download.com/wp-content/uploads/2016/12/World_Health_Organization_logo_logotype.png" alt="">
      </a>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'Country',
  props:{
      countryName: String,
      countryUrlName: String,
      casesTotal:Number,
  },
  data(){
        return{
            cases:''
        }
    },
  mounted(){
          const setRates = (data) => {  
            this.cases=data
            }
          const request = new XMLHttpRequest();
          request.onreadystatechange = onReady;
          request.responseType = 'json';
          request.open('GET', 'https://api.covid19api.com/total/dayone/country/'+this.countryUrlName.substring(0,this.countryUrlName.length-4)+'/status/confirmed');
          request.send();
          
          function onReady() {
            if (this.readyState === 4 && this.status === 200) {
              setRates(this.response.map(c=>c.Cases));
              var ctx = document.getElementById('myChart').getContext('2d');
              new Chart(ctx, {
                  type: 'line',
                  data: {
                      labels: this.response.map(c=>c.Date.substring(0,c.Date.length-10)),
                      datasets: [{
                          label: '# ilość zakażonych',
                          data: this.response.map(c=>c.Cases),
                          backgroundColor: 'rgba(255, 99, 132, 0.2)',
                          borderColor: 'rgba(255, 99, 132, 1)',
                          borderWidth: 1
                      }]
                  },
                  options: {
                      scales: {
                          yAxes: [{
                              ticks: {
                                  beginAtZero: true,
                              },
                          }]
                      }
                  }
              });
          }
          }},
}
</script>
<style scoped>
.chart{
  max-width: 80em;
  max-height: 50em;
}
.container2{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.fund{
  width: 100%;
  margin-top:50px;
  background: #eee;
}
.logo{
  width: 80%;
  height: auto;
}
</style>
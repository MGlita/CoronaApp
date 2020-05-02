<template>
  <div class="world">
    <div class="page_content">
    <div class="header"><p>Świat</p></div>
    <div class="secondary"><p>Strona przedstawiająca zachorowania w wybranych krajach</p></div>
    <div class="countries">
      <CountryBlock v-for="item in countries" v-bind:key="item.id" :country="item.name" :flag="item.flag" :count="item.rates"></CountryBlock>
    </div>
    </div>
  </div>
</template>
<script>
// @ is an alias to /src
import CountryBlock from '@/components/CountryBlock.vue'

export default {
  name: 'World',
  components: {
    CountryBlock
  },
  data(){
    return{
    countries:[
      {
        "name":"USA",
        "flag":"united-states.png",
        "rates":0
      },
      {
        "name":"Hiszpania",
        "flag":"spain.png",
        "rates":0
      },
      {
        "name":"Włochy",
        "flag":"italy.png",
        "rates":0
      },
      { 
        "name":"Francja",
        "flag":"france.png",
        "rates":0
      },
      {
        "name":"Niemcy",
        "flag":"germany.png",
        "rates":0
      },
      {
        "name":"Wielka Brytania",
        "flag":"united-kingdom.png",
        "rates":0
      },
      {
        "name":"Chiny",
        "flag":"china.png",
        "rates":0
      },
    ]}
  },
  beforeCreate(){
          const setRates = (data) => { 
            this.countries[0].rates = data.find(obj => {return obj.CountryCode==="US"}).TotalConfirmed;
            this.countries[1].rates = data.find(obj => {return obj.CountryCode==="ES"}).TotalConfirmed;
            this.countries[2].rates = data.find(obj => {return obj.CountryCode==="IT"}).TotalConfirmed;
            this.countries[3].rates = data.find(obj => {return obj.CountryCode==="FR"}).TotalConfirmed;
            this.countries[4].rates = data.find(obj => {return obj.CountryCode==="DE"}).TotalConfirmed;
            this.countries[5].rates = data.find(obj => {return obj.CountryCode==="GB"}).TotalConfirmed;
            this.countries[6].rates = data.find(obj => {return obj.CountryCode==="CN"}).TotalConfirmed;
            
            };
          const request = new XMLHttpRequest();
          request.onreadystatechange = onReady;
          request.responseType = 'json';
          request.open('GET', 'https://api.covid19api.com/summary');
          request.send();
          
          function onReady() {
            if (this.readyState === 4 && this.status === 200) {
              setRates(this.response.Countries);
          }
          }
        }
}
</script>
<style scoped>
.world {
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

.header{
  font-size: 70px;
  font-weight: 500;
}
.secondary{
  font-size: 30px;
  font-weight: 300;
  margin-top:60px;
}
.countries{
  margin-top: 100px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}

</style>
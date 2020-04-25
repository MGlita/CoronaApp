<template>
  <div class="world">
    <div class="header"><p>Świat</p></div>
    <div class="secondary"><p>Strona przedstawiająca zachorowania w wybranych krajach</p></div>
    <div class="countries">
      <CountryBlock v-for="item in countries" v-bind:key="item.id" :country="item.name" :flag="item.flag" :count="item.rates"></CountryBlock>
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
        "flag":"usa.png",
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
        "flag":"britain.png",
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
            this.countries[0].rates = data[236].TotalConfirmed;
            this.countries[1].rates = data[208].TotalConfirmed;
            this.countries[2].rates = data[108].TotalConfirmed;
            this.countries[3].rates = data[74].TotalConfirmed;
            this.countries[4].rates = data[81].TotalConfirmed;
            this.countries[5].rates = data[235].TotalConfirmed;
            this.countries[6].rates = data[45].TotalConfirmed;
            
            };
          const request = new XMLHttpRequest();
          request.onreadystatechange = onReady;
          request.responseType = 'json';
          request.open('GET', 'https://api.covid19api.com/summary');
          request.send();
          
          function onReady() {
            if (this.readyState === 4 && this.status === 200) {
              setRates(this.response.Countries);
              console.log(this.response.Countries);
          }
          }
        }
}
</script>
<style scoped>
.world{
  margin-top:30px;
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
<template>
    <div class="poland">
        <h1>Polska</h1>

        <h3>Mapa zachorowań w Polsce</h3>
        <l-map style="height: 500px;" :zoom="6" :center="[ 52.0651,  19.252522]" :options="mapOptions">
            <l-choropleth-layer :data="departmentData" titleKey="department_name" idKey="department_name"
                                :value="value" :extraValues="extraValues" geojsonIdKey="name" :geojson="geojson"
                                :colorScale="colorScale">
                <template slot-scope="props">
                    <l-info-control :item="props.currentItem" :unit="props.unit" title="Województwo"
                                    placeholder="Najedź by otrzymać dane"/>
                    <l-reference-chart title="Ilość zachorowań" :colorScale="colorScale" :min="props.min"
                                       :max="props.max" position="topright"/>
                </template>
            </l-choropleth-layer>
        </l-map>


        <div class="small">
            <h2>Dane historyczne</h2>
            <line-chart
                    v-if="loaded"
                    :chartdata="historyData"
                    :options="options"/>
            <canvas id="chart" />
        </div>
    </div>
</template>
<script>


    import {geojson} from '../assets/polandMapData.js'
    import {LMap} from 'vue2-leaflet';
    import 'leaflet/dist/leaflet.css';
    import {ChoroplethLayer, InfoControl, ReferenceChart} from "vue-choropleth";
    import LineChart from '../components/Chart'


    export default {
        name: "app",
        components: {
            LMap,
            LineChart,
            'l-info-control': InfoControl,
            'l-reference-chart': ReferenceChart,
            'l-choropleth-layer': ChoroplethLayer
        },
        data() {
            return {
                geojson,
                colorScale: ["e7d090", "e9ae7b", "de7062"],
                value: {
                    key: "confirmed",
                    metric: "potwierdzonych przypadków"
                },
                extraValues: [{
                    key: "dead",
                    metric: "śmierci"
                }],
                mapOptions: {
                    attributionControl: false
                },
                currentStrokeColor: '3d3213',
                departmentData: [],
                historyData: {
                    labels: [],
                    datasets: []},
                loaded: false,
                options: null,
            }
        },
        beforeCreate() {
            const mapToDepartmentData = (jsonArray) => {
                jsonArray.forEach(jsonElement => {
                    let province = {
                        department_name: jsonElement.name,
                        dead: jsonElement.deadAmount,
                        confirmed: jsonElement.confirmedAmount,
                    };
                    this.departmentData.push(province);
                });
            };

            fetch('http://longhorn.pl:7331/covid/province')
                .then((response) => {
                    return response.json();
                })
                .then((data) => {
                    mapToDepartmentData(data);
                });
        },
        mounted() {
            var requestOptions = {
                method: 'GET',
                redirect: 'follow'
            };

            fetch("https://api.covid19api.com/live/country/poland/status/confirmed", requestOptions)
                .then(response => response.json())
                .then(result => {
                    function getDate(result) {
                        let toReturn = [];
                        result.forEach(day => toReturn.push(day.Date.substring(0, 10)));
                        return toReturn;
                    }
                    function getConfirmed(result) {
                        let toReturn = [];
                        result.forEach(day => toReturn.push(day.Confirmed));
                        return toReturn;
                    }
                    function getDeath(result) {
                        let toReturn = [];
                        result.forEach(day => toReturn.push(day.Death));
                        return toReturn;
                    }
                    function getRecovered(result) {
                        let toReturn = [];
                        result.forEach(day => toReturn.push(day.Recovered));
                        return toReturn;
                    }
                    function getActive(result) {
                        let toReturn = [];
                        result.forEach(day => toReturn.push(day.Active));
                        return toReturn;
                    }

                    this.historyData.labels = getDate(result);
                    this.historyData.datasets = [{
                            label: 'Potwierdzone',
                            backgroundColor: '#722c3c',
                            data: getConfirmed(result)
                        },
                            {
                                label: 'Śmierci',
                                backgroundColor: '#679552',
                                data: getDeath(result)
                            },
                            {
                                label: 'Wyzdrowiali',
                                backgroundColor: '#9ea6ac',
                                data: getRecovered(result)
                            },
                            {
                                label: 'Aktywni',
                                backgroundColor: '#d47d23',
                                data: getActive(result)
                            }];
                    this.loaded = true;
                });
        }
    }
</script>
<style>
    #map {
        background-color: #eee;
    }
    .small {
        max-width: 1500px;
        margin-left: auto;
        margin-right: auto
    }
</style>
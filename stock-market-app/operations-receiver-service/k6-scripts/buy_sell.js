import http from 'k6/http';
import {check, sleep} from 'k6';

export default function() {

  const stocks = [
  	'WEGE3',
  	'LWSA3',
  	'ITSA4',
  	'ALUP11',
  	'EGIE3',
  	'ENBR3',
  	'VVAR3',
  ];

  const url = 'http://localhost:8080/operations/';

  const params = {
	headers: {
	  'Content-Type': 'application/json',
	},
  };

  const operation = {
	stock: stocks[Math.floor(Math.random() * stocks.length)],
	operationType: Math.floor(Math.random() * Math.floor(2)) === 0 ? 'BUY' : 'SELL',
	quantity: Math.floor(Math.random() * Math.floor(1000)),
	value: Math.floor(Math.random() * Math.floor(100))
  };

  const res = http.post(url, JSON.stringify(operation), params);

  check(res, { 'success sending operation': (r) => r.status === 200 });
  sleep(1);
}
import http from 'k6/http';
import {check, sleep} from 'k6';

const expensePayload = JSON.parse(open("../expense-transaction.json"));

export default function() {
  const url = 'http://bankaccount.ga/transaction-service/transactions';

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const res = http.post(url, JSON.stringify(expensePayload), params);

  check(res, { 'success creating expense': (r) => r.status === 201 });
  sleep(1);
}
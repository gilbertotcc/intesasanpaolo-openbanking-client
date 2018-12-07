Intesa Sanpaolo Open Banking Client
===================================

_[Draft of]_ Java client to use [Intesa Sanpaolo Open Banking API](https://openbanking.intesasanpaolo.com/).

Unfortunately the client implements only documented APIs available on _Playground_ environment. However you can
fork this repository and use code as starting point to build your own Intesa Sanpaolo Open Banking Java client.

Playground (fun) facts
----------------------

- Field `errors` in responses is `error` in `GET /v1/tools/iban/formal-check`.
- Dates. Examples show different formats and Jackson fails when deserializing `2017-12-31T23:59:60Z`: it doesn't
  like the value for the seconds field.
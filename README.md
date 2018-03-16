# Milli-Piyango-API

### Loto tipi: 

```
enum {
  "SAYISAL_LOTO",
  "ON_NUMARA",
  "SUPER_LOTO",
  "SANS_TOPU"
  }
```
### Tarih patterni (Date Pattern):

`"yyyyMMdd"`

## API KULLANIMI

### 10.03.2018 tarihli sayısal loto sonuçlarını çekmek için:

`http://a.nihatalim.com:8080/api-1.0.0.RELEASE/loto/get?type=SAYISAL_LOTO&date=20180310`

### 08.03.2018 tarihli süper loto sonuçlarını çekmek için:

`http://a.nihatalim.com:8080/api-1.0.0.RELEASE/loto/get?type=SUPER_LOTO&date=20180308`

# Swagger UI 

`http://a.nihatalim.com:8080/api-1.0.0.RELEASE/swagger-ui.html`

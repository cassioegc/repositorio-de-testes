const express = require("express");
const axios = require('axios');
const cors = require('cors');
const https = require('https');

const PORT = process.env.PORT || "8080";
const app = express();

app.use(cors());

app.get("/", (req, res) => {
  const data = req.query.data;

  const config = {
    method: 'get',
    maxBodyLength: Infinity,
    url: `https://sistemasweb.b3.com.br/PlantaoNoticias/Noticias/ListarTitulosNoticias?agencia=18&palavra=${req.query.papel}&dataInicial=${data}&dataFinal=${data}`,
    headers: { 
      'Accept': '*/*', 
      'Accept-Language': 'en-US,en;q=0.9,pt-BR;q=0.8,pt;q=0.7,es;q=0.6', 
      'Connection': 'keep-alive', 
      'Referer': 'https://sistemasweb.b3.com.br/PlantaoNoticias/Noticias/Index?agencia=18', 
      'Sec-Fetch-Dest': 'empty', 
      'Sec-Fetch-Mode': 'cors', 
      'Sec-Fetch-Site': 'same-origin', 
      'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36', 
      'X-Requested-With': 'XMLHttpRequest', 
      'sec-ch-ua': '"Google Chrome";v="125", "Chromium";v="125", "Not.A/Brand";v="24"', 
      'sec-ch-ua-mobile': '?0', 
      'sec-ch-ua-platform': '"Linux"', 
      'Cookie': 'TS0134a800=016e3b076f25eebd844952580d55e81857a18a6b363fb18af143996c31d1ac0618ddc70334a5d8d15c26f4cde697dac6744560b52d; dtCookie=v_4_srv_24_sn_B04DDE7CA36EE7E7378A598CC1690EC5_perc_100000_ol_0_mul_1_app-3Afd69ce40c52bd20e_1_rcs-3Acss_0; BIGipServerpool_sistemasweb.b3.com.br_443_WAF=4114163722.64288.0000; TS01871345=016e3b076f25eebd844952580d55e81857a18a6b363fb18af143996c31d1ac0618ddc70334a5d8d15c26f4cde697dac6744560b52d'
    },
    httpsAgent: new https.Agent({
      rejectUnauthorized: false
    })
  };

  axios.request(config)
    .then((response) => {
      res.json(response.data).send();
    })
    .catch((error) => {
      res.status(500)
    });

});

app.listen(parseInt(PORT, 10), () => {
  console.log(`Listening for requests on http://localhost:${PORT}`);
});

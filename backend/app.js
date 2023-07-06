const express = require("express");
const axios = require('axios');
const cors = require('cors');

const PORT = process.env.PORT || "8080";
const app = express();

app.use(cors());

app.get("/", (req, res) => {
  const data = req.query.data;

  let config = {
    method: 'get',
    maxBodyLength: Infinity,
    url: `https://sistemasweb.b3.com.br/PlantaoNoticias/Noticias/ListarTitulosNoticias?agencia=18&palavra=${req.query.papel}&dataInicial=${data}&dataFinal=${data}`,
    headers: {
      'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7',
      'Accept-Language': 'en-US,en;q=0.9,pt-BR;q=0.8,pt;q=0.7,es;q=0.6',
      'Cache-Control': 'max-age=0',
      'Connection': 'keep-alive',
      'Cookie': 'TS01871345=016e3b076f18257e9b4c4a3e17b835b554465a12443cdacd8b3a60b3ca77aff0504dcb90c46bd3a3b43563f825c2b371fa283620f2; TS0134a800=016e3b076f18257e9b4c4a3e17b835b554465a12443cdacd8b3a60b3ca77aff0504dcb90c46bd3a3b43563f825c2b371fa283620f2; BIGipServerpool_sistemasweb.b3.com.br_443_WAF=4114163722.64288.0000; dtCookie=v_4_srv_27_sn_4C3CB9D440F180CD8942BCD6080D061F_perc_100000_ol_0_mul_1_app-3A6c080359c6da1713_1_app-3A2fa0c7805985f6bf_1_rcs-3Acss_0',
      'Sec-Fetch-Dest': 'document',
      'Sec-Fetch-Mode': 'navigate',
      'Sec-Fetch-Site': 'none',
      'Sec-Fetch-User': '?1',
      'Upgrade-Insecure-Requests': '1',
      'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36',
      'sec-ch-ua': '"Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99"',
      'sec-ch-ua-mobile': '?0',
      'sec-ch-ua-platform': '"Linux"'
    }
  };

  axios.request(config)
    .then((response) => {
      res.json(JSON.stringify(response.data)).send();
    })
    .catch((error) => {
      res.status(500)
    });

});

app.listen(parseInt(PORT, 10), () => {
  console.log(`Listening for requests on http://localhost:${PORT}`);
});

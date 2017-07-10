const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();

const port = 3000;
const lostpets = require('./routes/lostPets');

app.use(cors());

app.use(bodyParser.json());

app.use(express.static(path.join(__dirname, "public")));

app.use('/lostpets', lostpets);

app.get('/', (req, res) => {
  res.send('Invalid endpoint');
});

app.listen(port, function () {
  console.log('listening on port ' + port);
});

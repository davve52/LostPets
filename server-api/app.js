const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const cors = require('cors');
const mongoose = require('mongoose');
const config = require('./config/database');
const app = express();

const port = 3000;
const lostpets = require('./routes/lostPets');

mongoose.Promise = global.Promise;
mongoose.connect(config.database);
mongoose.connection.on('connected', () => {
  console.log('Connected to database'+ config.database);
});

mongoose.connection.on('error', (err) => {
  console.log('Error: Database ' +err);
});

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

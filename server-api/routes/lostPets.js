const express = require('express');
const router = express.Router();


//Loads al the lost pets
router.get('/load-all', (req, res, next) => {
  res.send('Loading a list of al the lost pets');
});

//Loads a specific lost pet
router.get('/load', (req, res, next) => {
  res.send('Loading a specific pet');
});

//Adds a new lost pet post
router.post('/add', (req, res, next) => {
  res.send('Post a new pet');
});

//Adds image post of the found pet
router.post('/found', (req, res, next) => {
  res.send('Lost pet is found by someone');
});

//Pet is returned to is owner
router.post('/returned', (req, res, next) => {
  res.send('Pet is safely returned');
});

module.exports = router;

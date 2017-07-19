const express = require('express');
const router = express.Router();
const multer  = require('multer');
const path = require('path');
const pet = require('../models/pet');
const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, './lostPetImages');
  },
  filename: function (req, file, cb) {
    console.log(file);
    cb(null, file.fieldname + '-' + file.originalname);
  }
});

const upload = multer({ storage: storage });

//Loads al the lost pets
router.get('/load-all', (req, res, next) => {
  res.send('Loading a list of al the lost pets');
});

//Loads a specific lost pet
router.get('/load', (req, res, next) => {
  res.send('Loading a specific pet');
});

//Adds a new lost pet post working?
router.post('/upload', (req, res, next) => {
  let upload = multer({
		storage: storage
	}).single('lostpet');
	upload(req, res, function(err) {
		res.send('File is uploaded');
	});
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

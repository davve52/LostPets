const mongoose = require('mongoose');
const config = require('../config/database');

const PetSchema = mongoose.Schema({
  name:{
    type: String,
    required: true
  },
  description: {
    type: String,
    required: true
  },
  image: {
    type: String,
    required: true
  },
  phoneNbr:{
    type: String,
    required: true
  },
  returned: {
    type: Boolean,
    required: true
  },
  petfound: [
    found:{
      type: Boolean,
      required: true
    },
    location:[
      lat:{
        type:String,
        required: false
      },
      long:{
        type:String,
        required: false
      },
    ],
    foundImage: {
      type: String,
      required: true
    }
  ]
});

const Pet = module.exports = mongoose.model('Pet', PetSchema);

module.exports.loadPetById = function(id, callback){
  Pet.findById(id, callback);
}

module.exports.loadPets = function({}, callback){
  Pet.find({}, callback);
}

module.exports.saveLostPet = function(lostPet, callback){
  lostPet.save(callback);
}

//Fix this method later
module.exports.updatePet = function(info, callback){
  Pet.update({_id: info.id},{$set:{character: yass.id}}, callback);
}

module.exports = app => {
  const movieRating = require("../controllers/movieRating.controller.js");

  var router = require("express").Router();

  // Create a new Movie Rating
  router.post("/save", movieRating.create);

  // Retrieve all movie Rating
  router.get("/all", movieRating.findAll);

  app.use("/api/movieRating", router);
};

const db = require("../models");
const MovieRating = db.movierating;

// Create and Save a new Movie Rating Details
exports.create = (req, res) => {
  // Validate request
  if (!req.body.title) {
    res.status(400).send({ message: "Content can not be empty!" });
    return;
  }

  // Create a movieRating Model Object 
  const movieRating = new MovieRating({
    rating: req.body.rating,
    commentTitle: req.body.commentTitle,
    commentContent: req.body.commentContent,
    userId: req.body.userId,
    movieId: req.body.movieId
  });

  // Save movieRating in the database
  movieRating
    .save(movieRating)
    .then(data => {
      res.send(data);
    })
    .catch(err => {
      res.status(500).send({
        message:
          err.message || "Some error occurred while creating the movieRating."
      });
    });
};

// Retrieve all Movie Rating Details from the Mango ndatabase.
exports.findAll = (req, res) => {
  const movieid = req.query.movieid;
  var condition = movieid ? { movieid: { $regex: new RegExp(movieid), $options: "i" } } : {};

  movieRating.find(condition)
    .then(data => {
      res.send(data);
    })
    .catch(err => {
      res.status(500).send({
        message:
          err.message || "Some error occurred while retrieving movieRatings."
      });
    });
};


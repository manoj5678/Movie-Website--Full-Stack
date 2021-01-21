module.exports = mongoose => {
  var schema = mongoose.Schema(
    {
        rating: String,
        commentTitle: String,
        commentContent: String,
        userId: String,
        movieId: String
    },
    { timestamps: true }
  );

  schema.method("toJSON", function() {
    const { __v, _id, ...object } = this.toObject();
    object.id = _id;
    return object;
  });

  const MovieRating = mongoose.model("movieRating", schema);
  return MovieRating;
};

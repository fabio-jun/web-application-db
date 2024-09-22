package br.uel.gamehub.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uel.admgamehub.dao.ReviewDAO;
import br.uel.admgamehub.model.Review;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewDAO reviewDAO;

    public ReviewController(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        try {
            reviewDAO.create(review);
            return ResponseEntity.status(HttpStatus.CREATED).body(review);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{revIdJogo}/{revIdCliente}")
    public ResponseEntity<Review> getReview(@PathVariable int revIdJogo, @PathVariable int revIdCliente) {
        try {
            Review review = reviewDAO.read(revIdJogo, revIdCliente);
            if (review != null) {
                return ResponseEntity.ok(review);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{revIdJogo}/{revIdCliente}")
    public ResponseEntity<Review> updateReview(@PathVariable int revIdJogo, @PathVariable int revIdCliente, @RequestBody Review review) {
        try {
            review.setRevIdJogo(revIdJogo);
            review.setRevIdCliente(revIdCliente);
            reviewDAO.update(review);
            return ResponseEntity.ok(review);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{revIdJogo}/{revIdCliente}")
    public ResponseEntity<Void> deleteReview(@PathVariable int revIdJogo, @PathVariable int revIdCliente) {
        try {
            reviewDAO.delete(revIdJogo, revIdCliente);
            return ResponseEntity.noContent().build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        try {
            List<Review> reviewList = reviewDAO.all();
            return ResponseEntity.ok(reviewList);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

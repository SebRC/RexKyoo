package project.rexkyoo.Feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TA

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackModel, Integer>
{}

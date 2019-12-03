package project.rexkyoo.Feedback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Feedback.Model.FeedbackModel;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackModel, Integer>
{
}

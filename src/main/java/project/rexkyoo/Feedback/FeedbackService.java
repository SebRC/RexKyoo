package project.rexkyoo.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// TA

@Service
public class FeedbackService
{
    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<FeedbackModel> getAll()
    {
        return feedbackRepository.findAll();
    }

    public FeedbackModel getOne(int id)
    {
        return feedbackRepository.getOne(id);
    }

    public void save(FeedbackModel feedbackModel)
    {
        feedbackRepository.save(feedbackModel);
    }

    public void delete(int id)
    {
        feedbackRepository.deleteById(id);
    }
}

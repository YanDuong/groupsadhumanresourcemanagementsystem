package sad.humanresourcemanagementsystem.daoi;

import sad.humanresourcemanagementsystem.model.Evaluation;

public interface EvaluationDAOI {
int saveEvaluation(Evaluation e);
boolean updateEvaluation(Evaluation e);
Evaluation getEvaluationByTime(int date, int month);
}

package sad.humanresourcemanagementsystem.service;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.EvaluationDAOI;
import sad.humanresourcemanagementsystem.model.Evaluation;

public class EvaluationService {
private EvaluationDAOI evaluationDAOI;
public EvaluationService() {
	evaluationDAOI = DAOFactory.getEvalutionDAO();
}


public int saveEvaluation(Evaluation e) {
	return evaluationDAOI.saveEvaluation(e);
}
public boolean updateEvaluation(Evaluation e) {
	return evaluationDAOI.updateEvaluation(e);
}
public Evaluation getEvaluationByTime(int date, int month)  {
	return evaluationDAOI.getEvaluationByTime(date, month);
}

}

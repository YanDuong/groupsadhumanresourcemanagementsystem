package sad.humanresourcemanagementsystem.service;

import java.util.List;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.TrainingProgramDAOI;

public class TrainingProgramService {
private TrainingProgramDAOI programDAOI;
public TrainingProgramService() {
	programDAOI = DAOFactory.getTrainingProgramDAO();
}
int insertTrainingProgram(TrainingProgramDAOI program) {
	return programDAOI.insertTrainingProgram(program);
}
boolean updateTrainingProgram(TrainingProgramDAOI program) {
	return programDAOI.updateTrainingProgram(program);
}
boolean updateTrainingProgramStatus(int id, int status) {
	return programDAOI.updateTrainingProgramStatus(id, status);
}
List<TrainingProgramDAOI> getTrainingProgramByStatus(int status) {
	return programDAOI.getTrainingProgramByStatus(status);
}

}

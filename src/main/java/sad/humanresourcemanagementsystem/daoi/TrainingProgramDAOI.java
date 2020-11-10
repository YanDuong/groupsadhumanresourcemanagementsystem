package sad.humanresourcemanagementsystem.daoi;

import java.util.List;

public interface TrainingProgramDAOI {
int insertTrainingProgram(TrainingProgramDAOI program);
boolean updateTrainingProgram(TrainingProgramDAOI program);
boolean updateTrainingProgramStatus(int id, int status);
List<TrainingProgramDAOI> getTrainingProgramByStatus(int status);

}

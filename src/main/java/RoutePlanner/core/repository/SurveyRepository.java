package RoutePlanner.core.repository;

import RoutePlanner.core.domain.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Optional<Survey> findByUserID(String userID);

    boolean existsByUserID(String userID);
}

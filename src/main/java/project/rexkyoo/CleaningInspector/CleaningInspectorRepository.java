package project.rexkyoo.CleaningInspector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TA

@Repository
public interface CleaningInspectorRepository extends JpaRepository<CleaningInspectorModel, Integer>
{}

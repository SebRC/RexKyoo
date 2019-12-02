package project.rexkyoo.CleaningInspector.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.CleaningInspector.Models.CleaningInspectorModel;

@Repository
public interface CleaningInspectorRepository extends JpaRepository<CleaningInspectorModel, Integer>
{

}

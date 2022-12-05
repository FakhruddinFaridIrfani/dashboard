package com.project.dashboard.repository;

import com.project.dashboard.model.SystemParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SystemParameterRepository extends JpaRepository<SystemParameter, Integer> {

    @Query(value = "SELECT * FROM dashboard.system_parameter where status <> 'deleted'", nativeQuery = true)
    List<SystemParameter> getSystemParameter();

    @Modifying
    @Query(value = "UPDATE dashboard.system_parameter SET parameter_value=:parameter_value,updated_by=:updated_by,updated_date=current_timestamp,status=:status WHERE system_parameter_id =:system_parameter_id ", nativeQuery = true)
    void updateSystemParameter(@Param("parameter_value") String parameter_value,
                               @Param("updated_by") String updated_by, @Param("status") String status, @Param("system_parameter_id") int system_parameter_id);

    @Modifying
    @Query(value = "UPDATE dashboard.system_parameter SET status = 'deleted',updated_by=:updated_by,updated_date=current_timestamp WHERE system_parameter_id=:system_parameter_id", nativeQuery = true)
    void deleteSystemParameter(@Param("system_parameter_id") int system_parameter_id, @Param("updated_by") String updated_by);

    @Query(value = "SELECT * FROM dashboard.system_parameter WHERE lower(parameter_name) = lower(:parameter_name) AND status <> 'deleted'", nativeQuery = true)
    List<SystemParameter> getSystemParameterByName(@Param("parameter_name") String parameter_name);

    @Query(value = "SELECT * FROM dashboard.system_parameter WHERE lower(parameter_name) like lower(:parameter_name) AND system_parameter_id not in (:system_parameter_id) AND status <> 'deleted'", nativeQuery = true)
    List<SystemParameter> getParameterByNameExceptId(@Param("parameter_name") String parameter_name, @Param("system_parameter_id") int system_parameter_id);


}

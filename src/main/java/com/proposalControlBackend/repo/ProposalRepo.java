
package com.proposalControlBackend.repo;

import com.proposalControlBackend.entity.Proposal;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepo extends JpaRepository<Proposal, Long> {
    
    /*@Query("SELECT p FROM Proposal p WHERE (p.dateVersion >= ?16 AND p.dateVersion <= ?17 )"
            + "AND (?1 is null or p.company = ?1) AND (?2 is null or p.customer =?2)"
            + " AND (?3 is null or p.customerReference = ?3) "
            + "AND (?4 is null or p.servicioConcept = ?4) AND (?5 is null or p.typeOfService = ?5) "
            + "AND (?6 is null or p.currency = ?6) AND (?7 is null or p.baseAmount = ?7) AND (?8 is null or p.totalAmount = ?8) "
            + "AND (?9 is null or p.stateP = ?9) AND (?10 is null or p.wayToPay = ?10) AND (?11 is null or p.folder = ?11)"
            + "AND (?12 is null or p.wayToPayDays = ?12) AND (?13 is null or p.creatorUser = ?13)"
            + "AND (?14 is null or p.version = ?14) AND (?15 is null or p.code = ?15)")
    List<Proposal> search(@Param("company") String company, @Param("customer") String customer,
            @Param("customerReference") String customerReference,
            @Param("servicioConcept") String servicioConcept,
            @Param("typeOfService") String typeOfService, @Param("currency") String currency,
            @Param("baseAmount") Integer baseAmount,  @Param("totalAmount") Integer totalAmount,
            @Param("stateP") String stateP,  @Param("wayToPay") String wayToPay, 
            @Param("folder") String folder, @Param("wayToPayDays") Integer wayToPayDays,
            @Param("creatorUser") String creatorUser, @Param("version") Integer version,
            @Param("code") String code, @Param("startDate") Date startDate, @Param("endDate") Date endDate
            );*/
    
    @Query("SELECT p FROM Proposal p WHERE (p.dateVersion >= :startDate AND p.dateVersion <= :endDate )"
            + "AND (:company is null or p.company = :company) AND (:customer is null or p.customer = :customer)"
            + " AND (:customerReference is null or p.customerReference = :customerReference) "
            + "AND (:servicioConcept is null or p.servicioConcept = :servicioConcept) AND "
            + "(:typeOfService is null or p.typeOfService = :typeOfService) "
            + "AND (:currency is null or p.currency = :currency) "
            + "AND (:baseAmount is null or p.baseAmount = :baseAmount) "
            + "AND (:totalAmount is null or p.totalAmount = :totalAmount) "
            + "AND (:stateP is null or p.stateP = :stateP) "
            + "AND (:wayToPay is null or p.wayToPay = :wayToPay) AND (:folder is null or p.folder = :folder)"
            + "AND (:wayToPayDays is null or p.wayToPayDays = :wayToPayDays) "
            + "AND (:creatorUser is null or p.creatorUser = :creatorUser)"
            + "AND (:version is null or p.version = :version) AND (:code is null or p.code = :code)")
    List<Proposal> search(@Param("company") String company, @Param("customer") String customer,
            @Param("customerReference") String customerReference,
            @Param("servicioConcept") String servicioConcept,
            @Param("typeOfService") String typeOfService, @Param("currency") String currency,
            @Param("baseAmount") Integer baseAmount,  @Param("totalAmount") Integer totalAmount,
            @Param("stateP") String stateP,  @Param("wayToPay") String wayToPay, 
            @Param("folder") String folder, @Param("wayToPayDays") Integer wayToPayDays,
            @Param("creatorUser") String creatorUser, @Param("version") Integer version,
            @Param("code") String code, @Param("startDate") Date startDate, @Param("endDate") Date endDate
            );
    
    @Query("SELECT p FROM Proposal p WHERE  p.dateVersion BETWEEN ?1 AND ?2")
    List<Proposal> searchDate(@Param("startDate")Date startDate, @Param("endDate") Date endDate);
       //@Query(value = "from EntityClassTable t where yourDate BETWEEN :startDate AND :endDate")

     
    @Query("SELECT p FROM Proposal p WHERE p.id =?1")
    Proposal searchByProposalId(@Param("id") Long id);
    
    //List<Proposal> findByCreatedAtBetween(Date startDate, Date endDate);
    
    /*@Query(value = "from Proposal t where dateVersion BETWEEN :startDate AND :endDate")
    List<Proposal> getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);*/
    
    //@Query("SELECT p FROM Proposal p WHERE p.id =?1")
    //Proposal searchById(@Param("id") Long id);
    
    /* @Query("SELECT p FROM Proposal p WHERE p.id =?1")
    List<Proposal> searchByPropuesta(@Param("id") Integer id);*/
    
}
/*

package com.proposalControl.repo;

import com.proposalControl.entity.ProposedVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposedVersionRepo extends JpaRepository<ProposedVersion, Long>  {
    
}

*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arif Fridasari
 */
@Entity
@Table(name = "LEAVE_REQUESTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveRequest.findAll", query = "SELECT l FROM LeaveRequest l")
    , @NamedQuery(name = "LeaveRequest.findById", query = "SELECT l FROM LeaveRequest l WHERE l.id = :id")
    , @NamedQuery(name = "LeaveRequest.findByStartDate", query = "SELECT l FROM LeaveRequest l WHERE l.startDate = :startDate")
    , @NamedQuery(name = "LeaveRequest.findByEndDate", query = "SELECT l FROM LeaveRequest l WHERE l.endDate = :endDate")
    , @NamedQuery(name = "LeaveRequest.findByNotes", query = "SELECT l FROM LeaveRequest l WHERE l.notes = :notes")
    , @NamedQuery(name = "LeaveRequest.findByIsDelete", query = "SELECT l FROM LeaveRequest l WHERE l.isDelete = :isDelete")})
public class LeaveRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "NOTES")
    private String notes;
    @Basic(optional = false)
    @Column(name = "IS_DELETE")
    private Character isDelete;
    @JoinColumn(name = "REQUESTER", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee requester;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
    @JoinColumn(name = "TYPE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LeaveType type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveRequest", fetch = FetchType.LAZY)
    private List<LeaveRequestStatus> leaveRequestStatusList;

    public LeaveRequest() {
    }

    public LeaveRequest(Long id) {
        this.id = id;
    }

    public LeaveRequest(Long id, Date startDate, Date endDate, String notes, Employee requester, LeaveType type) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
        this.requester = requester;
        this.type = type;
    }


    public LeaveRequest(Long id, Date startDate, Date endDate, String notes, Character isDelete) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
        this.isDelete = isDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Character getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Character isDelete) {
        this.isDelete = isDelete;
    }

    public Employee getRequester() {
        return requester;
    }

    public void setRequester(Employee requester) {
        this.requester = requester;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LeaveType getType() {
        return type;
    }

    public void setType(LeaveType type) {
        this.type = type;
    }

    @XmlTransient
    public List<LeaveRequestStatus> getLeaveRequestStatusList() {
        return leaveRequestStatusList;
    }

    public void setLeaveRequestStatusList(List<LeaveRequestStatus> leaveRequestStatusList) {
        this.leaveRequestStatusList = leaveRequestStatusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeaveRequest)) {
            return false;
        }
        LeaveRequest other = (LeaveRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.LeaveRequest[ id=" + id + " ]";
    }
    
}

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
@Table(name = "LEAVE_REQUEST_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveRequestStatus.findAll", query = "SELECT l FROM LeaveRequestStatus l")
    , @NamedQuery(name = "LeaveRequestStatus.findById", query = "SELECT l FROM LeaveRequestStatus l WHERE l.id = :id")
    , @NamedQuery(name = "LeaveRequestStatus.findByStatusDate", query = "SELECT l FROM LeaveRequestStatus l WHERE l.statusDate = :statusDate")})
public class LeaveRequestStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "STATUS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status", fetch = FetchType.LAZY)
    private List<LeaveRequest> leaveRequestList;
    @JoinColumn(name = "LEAVE_REQUEST", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LeaveRequest leaveRequest;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;

    public LeaveRequestStatus() {
    }

    public LeaveRequestStatus(Long id, LeaveRequest leaveRequest, Status status,Date statusDate) {
        this.id = id;
        this.statusDate = statusDate;
        this.leaveRequest = leaveRequest;
        this.status = status;
    }
    
    

    public LeaveRequestStatus(Long id) {
        this.id = id;
    }

    public LeaveRequestStatus(Long id, Date statusDate) {
        this.id = id;
        this.statusDate = statusDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @XmlTransient
    public List<LeaveRequest> getLeaveRequestList() {
        return leaveRequestList;
    }

    public void setLeaveRequestList(List<LeaveRequest> leaveRequestList) {
        this.leaveRequestList = leaveRequestList;
    }

    public LeaveRequest getLeaveRequest() {
        return leaveRequest;
    }

    public void setLeaveRequest(LeaveRequest leaveRequest) {
        this.leaveRequest = leaveRequest;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        if (!(object instanceof LeaveRequestStatus)) {
            return false;
        }
        LeaveRequestStatus other = (LeaveRequestStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.LeaveRequestStatus[ id=" + id + " ]";
    }
    
}

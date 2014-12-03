package com.udcode.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_teamright")
public class TeamRights {
	private User user;
	private Team team;
	private int teamRight = 2;

	private Long id;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne
	@JoinColumn(name="user_id",insertable=true,unique=true)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToOne
	@JoinColumn(name="team_id",insertable=true,unique=true)
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	@Column(name="right",length=10)
	public int getTeamRight() {
		return teamRight;
	}

	public void setTeamRight(int teamRight) {
		this.teamRight = teamRight;
	}
	

}

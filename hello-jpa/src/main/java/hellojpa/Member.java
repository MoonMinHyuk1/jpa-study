package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

//@SequenceGenerator(
//        name="member_seq_generator",
//        sequenceName = "member_seq", //매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1, allocationSize = 50
//)
@Entity
public class Member extends BaseEntity {
    //다양한 연관관계 매핑
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD",
            joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS",
//            joinColumns = @JoinColumn(name = "MEMBER_ID"))
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",
                column=@Column(name="WORK_CITY")),
            @AttributeOverride(name="street",
                column=@Column(name="WORK_STREET")),
            @AttributeOverride(name="zipcode",
                    column=@Column(name="WORK_ZIPCODE"))
    })
    private Address workAddress;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public List<MemberProduct> getMemberProducts() {
        return memberProducts;
    }

    public void setMemberProducts(List<MemberProduct> memberProducts) {
        this.memberProducts = memberProducts;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

//    public List<Address> getAddressHistory() {
//        return addressHistory;
//    }
//
//    public void setAddressHistory(List<Address> addressHistory) {
//        this.addressHistory = addressHistory;
//    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }


    //    //연관관계 매핑 기초
//    @Id @GeneratedValue
//    @Column(name = "MEMBER_ID")
//    private Long id;
//    @Column(name = "USERNAME")
//    private String username;
////    @Column(name = "TEAM_ID")
////    private Long teamId;
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
////    public Long getTeamId() {
////        return teamId;
////    }
////
////    public void setTeamId(Long teamId) {
////        this.teamId = teamId;
////    }
//
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this); //객체지향스럽게
//    }

//엔티티 매핑
//    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
//    private Long id;
//
////    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
////    private Long id;
//    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default 'EMPTY'") //NOT NULL
//    private String username;
////    private int age;
////    @Enumerated(EnumType.STRING)
////    private RoleType roleType;
////    @Temporal(TemporalType.TIMESTAMP)
////    private Date createdDate;
////    @Temporal(TemporalType.TIMESTAMP)
////    private Date lastModifiedDate;
////    @Lob
////    private String description;
////    @Transient
////    private int temp;
////
////    private LocalDate testLocalDate;
////    private LocalDateTime testLocalDateTime;
//
//    public Member() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
////    public int getAge() {
////        return age;
////    }
////
////    public void setAge(int age) {
////        this.age = age;
////    }
////
////    public RoleType getRoleType() {
////        return roleType;
////    }
////
////    public void setRoleType(RoleType roleType) {
////        this.roleType = roleType;
////    }
////
////    public Date getCreatedDate() {
////        return createdDate;
////    }
////
////    public void setCreatedDate(Date createdDate) {
////        this.createdDate = createdDate;
////    }
////
////    public Date getLastModifiedDate() {
////        return lastModifiedDate;
////    }
////
////    public void setLastModifiedDate(Date lastModifiedDate) {
////        this.lastModifiedDate = lastModifiedDate;
////    }
////
////    public String getDescription() {
////        return description;
////    }
////
////    public void setDescription(String description) {
////        this.description = description;
////    }
////
////    public int getTemp() {
////        return temp;
////    }
////
////    public void setTemp(int temp) {
////        this.temp = temp;
////    }
}

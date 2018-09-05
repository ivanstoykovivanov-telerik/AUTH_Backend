package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models;

import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.files.models.File;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.models.Tag;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.User2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String version;

    private Date uploadDate;

    @ManyToOne
    private User2 owner;

    @Column(columnDefinition = "INT DEFAULT 0")
    private long numberOfDownloads;

    @Column(nullable = false, unique = true)
    private String downloadLink;

    @Column(nullable = false, unique = true)
    private String sourceRepositoryLink;

    private long openIssues;

    private long pullRequests;

    private Date lastCommitDate;

    @Column(columnDefinition = "VARCHAR(50) DEFAULT 'pending'", nullable = false)
    private String productState;

    @ManyToMany
    private List<Tag> tags;

    @OneToOne(cascade = CascadeType.ALL)
    private File file;

    @OneToOne(cascade = CascadeType.ALL)
    private File productPicture;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<File> descriptionPictures;

    public Product() {
        this.tags= new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public User2 getOwner() {
        return owner;
    }

    public void setOwner(User2 owner) {
        this.owner = owner;
    }

    public long getNumberOfDownloads() {
        return numberOfDownloads;
    }

    public void setNumberOfDownloads(long numberOfDownloads) {
        this.numberOfDownloads = numberOfDownloads;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public String getSourceRepositoryLink() {
        return sourceRepositoryLink;
    }

    public void setSourceRepositoryLink(String sourceRepositoryLink) {
        this.sourceRepositoryLink = sourceRepositoryLink;
    }

    public long getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(long openIssues) {
        this.openIssues = openIssues;
    }

    public long getPullRequests() {
        return pullRequests;
    }

    public void setPullRequests(long pullRequests) {
        this.pullRequests = pullRequests;
    }

    public Date getLastCommitDate() {
        return lastCommitDate;
    }

    public void setLastCommitDate(Date lastCommitDate) {
        this.lastCommitDate = lastCommitDate;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(File productPicture) {
        this.productPicture = productPicture;
    }

//    public List<File> getDescriptionPictures() {
//        return descriptionPictures;
//    }
//
//    public void setDescriptionPictures(List<File> descriptionPictures) {
//        this.descriptionPictures = descriptionPictures;
//    }
}

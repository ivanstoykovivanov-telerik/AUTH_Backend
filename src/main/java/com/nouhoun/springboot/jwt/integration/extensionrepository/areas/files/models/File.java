package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.files.models;

import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.User2;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private long size;

    @Column(nullable = false)
    private String fileLocation;

    @Column(nullable = false)
    private String downloadLink;

    @OneToOne
    private User2 owner;

    public File() {
    }

    public File(String fileName, String type, long size, String fileLocation, String downloadLink) {
        setFileName(fileName);
        setType(type);
        setSize(size);
        setFileLocation(fileLocation);
        setDownloadLink(downloadLink);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public User2 getOwner() {
        return owner;
    }

    public void setOwner(User2 owner) {
        this.owner = owner;
    }
}
package ru.esbt.adres.entity;

import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Y.Pashnina
 */

@Entity
@Table(name = "CM_NASPUNKT")
public class Naspunkt implements Serializable {
 
 private static final long serialVersionUID = -5527566248002296042L;
  
 @Id
 @Column(name = "CM_OKATO")
 private Integer cmOkato;
  
 @Column(name = "CM_CTEXT")
 private String cmCtext;
  
 @Column(name = "CM_SOCR")
 private String cmSocr;
  
 @Column(name = "CM_NTERR")
 private Integer cmNterr;

 @Column(name = "CM_POSELEN")
 private String cmPoselen;
  
 @Column(name = "STATE")
 private String state;
  
 
 public Integer getCmOkato() {
  return cmOkato;
 }
 
 public void setCmOkato(Integer cmOkato) {
  this.cmOkato = cmOkato;
 }
 
 public String getCmCtext() {
  return cmCtext;
 }
 
 public void setCmCtext(String cmCtext) {
  this.cmCtext = cmCtext;
 }
 
 public String getCmSocr() {
  return cmSocr;
 }
 
 public void setCmSocr(String cmSocr) {
  this.cmSocr = cmSocr;
 }
 
 public Integer getCmNterr() {
  return cmNterr;
 }
 
 public void setCmNterr(Integer cmNterr) {
  this.cmNterr = cmNterr;
 }
    
 public String getCmPoselen() {
  return cmPoselen;
 }
 
 public void setCmPoselen(String cmPoselen) {
  this.cmPoselen = cmPoselen;
 }
 
 public String getState() {
  return cmPoselen;
 }
 
 public void setState(String state) {
  this.state = state;
 }
 
}

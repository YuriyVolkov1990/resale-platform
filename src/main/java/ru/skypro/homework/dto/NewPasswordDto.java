package ru.skypro.homework.dto;

import lombok.*;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewPasswordDto {
    @Size(min = 8, max = 16)
    private String currentPassword;
    @Size(min = 8, max = 16)
    private String newPassword;
//    public NewPasswordDto() {
//    }
//
//    public NewPasswordDto(String currentPassword, String newPassword) {
//        this.currentPassword = currentPassword;
//        this.newPassword = newPassword;
//    }
//
//    public String getCurrentPassword() {
//        return currentPassword;
//    }
//
//    public void setCurrentPassword(String currentPassword) {
//        this.currentPassword = currentPassword;
//    }
//
//    public String getNewPassword() {
//        return newPassword;
//    }
//
//    public void setNewPassword(String newPassword) {
//        this.newPassword = newPassword;
//    }
}

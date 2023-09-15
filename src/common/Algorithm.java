/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import model.Candidate;

import java.util.ArrayList;
import java.util.Scanner;
import model.Experience;
import model.Fresher;
import model.Intern;

/**
 *
 * @author CongThanh
 */
public class Algorithm extends ArrayList<Candidate> {

    Library library = new Library();
    Scanner sc = new Scanner(System.in);

    public void creating(int candidate) {
        String candidateId = library.inputString("Input candidate ID: ");
        String firstName = library.inputString("Input first name candidate: ");
        String lastName = library.inputString("Input last name candidate: ");
        String birthDate = library.inputString("Input birth date candidate: ");
        String address = library.inputString("Input address candidate: ");
        String phone = library.inputString("Input phone candidate: ");
        String email = library.inputString("Input email candidate: ");
        int candidateType = library.getInt("Input candidate type: ");

        candidate = library.getInt("Input three value of candidate type:", 0, 2);
        switch (candidate) {
            case 0:
                int explnYear = library.getInt("Input year of experience: ");
                String proSkill = library.inputString("Input Professional Skill: ");
                this.add(new Experience(explnYear, proSkill, candidateId, firstName,
                        lastName, birthDate, address, phone, email, candidateType));
                break;

            case 1:
                String graduationDate = library.inputString("Input graduated time: ");
                String graduationRank = library.inputString("Input rank of Graduation: ");
                String education = library.inputString("Input university where student graduated: ");
                this.add(new Fresher(graduationDate, graduationRank, education, candidateId, firstName,
                        lastName, birthDate, address, phone, email, candidateType));
                break;

            default:
                String majors = library.inputString("Input Majors: ");
                String semester = library.inputString("Input semester: ");
                String universityName = library.inputString("Input university name: ");
                this.add(new Intern(majors, semester, universityName, candidateId, firstName,
                        lastName, birthDate, address, phone, email, candidateType));
        }
    }

    public void update(String candidateId) {
        for (Candidate candi : this) {
            if (candi.getCandidateId().equalsIgnoreCase(candidateId)) {
                int candidateType = candi.getCandidateType();
                String address = library.inputString("Input update address : ");
                candi.setAddress(address);
                String phone = library.inputString("Input update phone: ");
                candi.setPhone(phone);
                String email = library.inputString("Input update email: ");
                candi.setEmail(email);
                switch (candidateType) {
                    case 0:
                        int ExplnYear = library.getInt("Input update year experience: ");
                        ((Experience) candi).setExpInYear(ExplnYear);
                        String proSkill = library.inputString("Input update professional skill: ");
                        ((Experience) candi).setProSkill(proSkill);
                        break;
                    case 1:
                        String graduationDate = library.inputString("Input update graduation date: ");
                        ((Fresher) candi).setGraduationDate(graduationDate);
                        String graduationRank = library.inputString("Input update graduation rank : ");
                        ((Fresher) candi).setGraduationRank(graduationRank);
                        String education = library.inputString("Input update university : ");
                        ((Fresher) candi).setEducation(education);
                        break;
                    default:
                        String majors = library.inputString("Input candidate majors : ");
                        ((Intern) candi).setMajors(majors);
                        String semester = library.inputString("Input candidate semester : ");
                        ((Intern) candi).setSemester(semester);
                        String universityIntern = library.inputString("Input candidate university : ");
                        ((Intern) candi).setUniversity(universityIntern);
                }
            }
        }
    }

    public void deleting(String candidateId) {
        try {
            for (Candidate candi : this) {
                if (candi.getCandidateId().equalsIgnoreCase(candidateId)) {
                    this.remove(candi);
                } else {
                    System.out.println("Candidate Id not found to remove");
                }
            }
        } catch (Exception e) {
        }
    }

    public Candidate search(String candidateId) {
        for (Candidate candi : this) {
            if (candi.getCandidateId().equalsIgnoreCase(candidateId)) {
                return candi;
            }
        }
        return null;
    }

    public void display() {
        for (Candidate candidate : this) {
            System.out.println(candidate);
        }
    }
}

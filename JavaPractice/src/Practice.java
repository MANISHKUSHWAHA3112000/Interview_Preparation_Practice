import java.util.HashSet;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
      int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
     
     int k=0;
     
     
     for(int i=0;i<arr.length;i++) {
    	if(arr[i]!=0) {
    		arr[k++]=arr[i];
    	}
     }
     while(k<arr.length) {
    	 arr[k++]=0;
     }
     
     for(int num : arr) {
    	 System.out.print("final array is : "+num+ " "+"\n");
     }
     
    }
}

/**
 * ---

## Professional Self-Introduction

"Good [morning/afternoon]. My name is Manish Kushwaha. I'm a Full Stack Developer based in Bangalore, currently working as a Senior Analyst at Capgemini — a role I was promoted to in May 2025, roughly eighteen months after joining.

Over the past two and a half years, I've been part of a team delivering software that real engineers in a real airline depend on every single day. That kind of environment — where the stakes are high and the system simply cannot afford to fail — has shaped how I think about my work. I care about reliability, I write code that others can read and maintain, and I treat production with the seriousness it deserves.

On the technical side, I work across the full stack — Java and Spring Boot on the backend, Angular on the frontend, PostgreSQL for data, and Kubernetes with Helm for deployments. Beyond building features, I've driven major version migrations across Spring Boot, Angular, and the database layer on a live codebase — keeping everything in production throughout. I've also built RESTful APIs integrating multiple external systems and optimised data-heavy Angular screens, delivering a 35% improvement in page load speed for over 500 active users.

I hold Azure certifications at both AZ-900 and AZ-204 level, I graduated with an 8.75 CGPA in Computer Science, and I work in Agile teams where I take full ownership — from the initial design conversation through to deployment and production monitoring.

I'm here because I'm ready for a bigger challenge. I want to work across diverse clients, complex problem spaces, and a team that pushes me further. I'm confident I can contribute from day one, and I'm genuinely looking forward to this conversation."*/

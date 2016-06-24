package com.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Java Program to loop through Map in Java. This examples 
 * shows three ways of traversing through Map, 
 * foreach loop, Iterator with set of keys, entries and
 * values from Map.
 *
 * @author Javin Paul
 */

public class MapLoopDemo {
    private static final Map<Integer, Worker> workersById = new HashMap<>();

    public static void main(String args[]) {

        // let's initialize Map for useworkersById.put(76832, new Worker(76832, "Tan", 8000));
        workersById.put(76833, new Worker(76833, "Tim", 3000));
        workersById.put(76834, new Worker(76834, "Tarun", 5000));
        workersById.put(76835, new Worker(76835, "Nikolai", 6000));
        workersById.put(76836, new Worker(76836, "Roger", 3500));

        // looping through map using foreach loop
        // print initial salary of workers
        System.out.println("Initial Salaries of workers");
        // alan wrote the coide below
        // HashMap is 
        Map<Integer,Worker> map = new HashMap<>();
        
        map.put(76833, new Worker(76833, "Tim", 3000));
        map.put(76834, new Worker(76834, "Tarun", 5000));
        map.put(76835, new Worker(76835, "Nikolai", 6000));
        map.put(76836, new Worker(76836, "Roger", 3500)); 
        
        // first loop using entrySet , show worked salary
        Set<Map.Entry<Integer,Worker>> entryAll= map.entrySet();
        
        for (Map.Entry<Integer,Worker> i : entryAll) {
        	System.out.println("Worker salary "+i.getValue().getSalary());
        }
        
        // second loop using iterator, 
        // first create a keySet iterator
        // increase salary 8%
        /*        
        Iterator<Integer> itr = map.keySet().iterator();
        
        while (itr.hasNext()) {
        	Worker cur = map.get(itr.next());
        	int sal = (int) (cur.getSalary()*1.08);
        	cur.setSalary(sal);
        }
        */ 
        // third loop , or use keySet directly
        Set<Integer> ks = map.keySet();
        for (Integer i:ks){
        	Worker cur = map.get(i);
        	int sal = (int) (cur.getSalary()*1.08);
        	cur.setSalary(sal);
        }
        // fourth loop, first get values set using collection to display the salary
        // note map.values() has to use Collection, can not use Set
        
        Collection<Worker> ws = map.values();
        
        for (Worker w:ws){
        	System.out.println("New salaries are "+w.getSalary());
        }
        
        /*

        Set<Map.Entry<Integer, Worker>> entrySet = workersById.entrySet();

        for (Map.Entry<Integer, Worker> entry : entrySet) {
            Worker worker = entry.getValue();
            System.out.printf("%s :\t %d %n", worker.getName(),
                    worker.getSalary());
        }
        */

        // looping through map using Iterator
        // updating salary of each worker
        
        /*
        Iterator<Integer> itr = workersById.keySet().iterator();
        while (itr.hasNext()) {
            Worker current = workersById.get(itr.next());
            int increasedSalary = (int) (current.getSalary() * 1.08);
            current.setSalary(increasedSalary);
        }
        */

        // how to loop map using for loop
        // looping through values using for loop
        
        /*
        Collection<Worker> workers = workersById.values();
        System.out.println("New Salaries of Workers : ");
        for (Worker worker : workers) {
            System.out.printf("%s :\t %d %n", worker.getName(),
                    worker.getSalary());
        }
        */

    }

    private static class Worker {

        private int id;
        private String name;
        private int salary;

        public Worker(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public final int getId() {
            return id;
        }

        public final String getName() {
            return name;
        }

        public final int getSalary() {
            return salary;
        }

        public final void setId(int id) {
            this.id = id;
        }

        public final void setName(String name) {
            this.name = name;
        }

        public final void setSalary(int d) {
            this.salary = d;
        }

        @Override
        public String toString() {
            return "Worker [id=" + id + ", name=" + name + ", salary=" + salary
                    + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + (int) (salary ^ (salary >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Worker other = (Worker) obj;
            if (id != other.id) {
                return false;
            }
            if (name == null) {
                if (other.name != null) {
                    return false;
                }
            } else if (!name.equals(other.name)) {
                return false;
            }
            if (salary != other.salary) {
                return false;
            }
            return true;
        }
    }
}
/*
Output:
Initial Salaries of workers
Tim :    3000
Tan :    8000
Nikolai :        6000
Tarun :  5000
Roger :  3500
New Salaries of Workers :
Tim :    3240
Tan :    8640
Nikolai :        6480
Tarun :  5400
Roger :  3780

*/

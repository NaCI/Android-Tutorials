package com.example.naci.daggertutorial_1;

public class FundamentalDITechniques {

    class Client {
        private final Service1 mService1;
        private Service2 mService2;

        // Field Injection Sample
        public Service3 mService3;

        // Constructor Injection Sample
        public Client(Service1 service1) {
            mService1 = service1;
        }

        // Method Injection Sample
        public Service2 getService2() {
            return mService2;
        }

        public void doSomething() {
            mService1.doSomething();
            mService2.doSomething();
            mService3.doSomething();
        }
    }

    class Service1 {
        void doSomething() {
            System.out.println("Service1");
        }
    }

    class Service2 {
        void doSomething() {
            System.out.println("Service2");
        }
    }

    class Service3 {
        void doSomething() {
            System.out.println("Service3");
        }
    }
}

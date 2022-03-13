package com.glearning.pg.client;

enum empDepartment {
    TECHNICAL {
        public String toString() {
            return "tech";
        }
    },
    ADMIN {
        public String toString() {
            return "admin";
        }
    },
    LEGAL {
        public String toString() {
            return "legal";
        }
    },
    HR {
        public String toString() {
            return "hr";
        }
    }
}


abstract class Department {
    abstract public String generateDomainAddress(empDepartment department);

}
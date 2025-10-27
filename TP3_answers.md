# TP1 Answers 
Student : Ivan Arturo GRANDI FLORES
Major : Software Engineering


**3-1 Document your inventory and base commands**
From Powershell
```wsl```

From wsl we executed the next commands

We create a directory to store the key in the Home folder of WSL
```mkdir -p ~/.ssh```

We copy the content the of id_rsa key from were it is located
```cp /mnt/c/Users/ivang/Documents/Clases/Efrei/Semestre_7/Docker/Docker-TPs-Ivan-Grandi/ansible/id_rsa ~/.ssh/```

We change the permissions so that it is only readable by the owner.

```chmod 400 ~/.ssh/id_rsa```

We create the connection and login to the server
```
ssh -i ~/.ssh/id_rsa admin@ivan-arturo.grandi-flores.takima.cloud
```

Output from the previous command
```
ivan@LAPTOP-737HG9IA:/mnt/c/Users/ivang/Documents/Clases/Efrei/Semestre_7/Docker/Docker-TPs-Ivan-Grandi/ansible$ ssh -i ~/.ssh/id_rsa admin@ivan-arturo.grandi-flores.takima.cloud
Linux ip-10-0-1-71 6.1.0-26-cloud-amd64 #1 SMP PREEMPT_DYNAMIC Debian 6.1.112-1 (2024-09-30) x86_64

The programs included with the Debian GNU/Linux system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Debian GNU/Linux comes with ABSOLUTELY NO WARRANTY, to the extent
permitted by applicable law.
```

We get the last updates for linux
```sudo apt update```

We install ansible
```sudo apt install ansible -y```
We ping the server
```ansible all -i inventories/setup.yml -m ping```

Output from previous command
```
my-server | SUCCESS => {
    "ansible_facts": {
        "discovered_interpreter_python": "/usr/bin/python3"
    },
    "changed": false,
    "ping": "pong"
}
```

Get OS distribution

```ansible all -i inventories/setup.yml -m setup -a "filter=ansible_distribution*"```

Remove apache2
```ansible all -i inventories/setup.yml -m apt -a "name=apache2 state=absent" --become```


**3-2 Document your playbook**

Playbook.yml at this step

```
- hosts: all
  gather_facts: true
  become: true


  roles:
    - docker
```

The tasks were passed to the main.yml file in folder roles/docker/tasks.
```
---
# tasks file for roles/docker

# Install prerequisites for Docker
- name: Install required packages
  apt:
    name:
      - apt-transport-https
      - ca-certificates
      - curl
      - gnupg
      - lsb-release
      - python3-venv
    state: latest
    update_cache: yes


# Add Docker’s official GPG key
- name: Add Docker GPG key
  apt_key:
    url: https://download.docker.com/linux/debian/gpg
    state: present


# Set up the Docker stable repository
- name: Add Docker APT repository
  apt_repository:
    repo: "deb [arch=amd64] https://download.docker.com/linux/debian {{ ansible_facts['distribution_release'] }} stable"
    state: present
    update_cache: yes


# Install Docker
- name: Install Docker
  apt:
    name: docker-ce
    state: present



# Install Python3 and pip3
- name: Install Python3 and pip3
  apt:
    name:
      - python3
      - python3-pip
    state: present


# Create a virtual environment for Python packages
- name: Create a virtual environment for Docker SDK
  command: python3 -m venv /opt/docker_venv
  args:
    creates: /opt/docker_venv  # Only runs if this directory doesn’t exist


# Install Docker SDK for Python in the virtual environment
- name: Install Docker SDK for Python in virtual environment
  command: /opt/docker_venv/bin/pip install docker


# Ensure Docker is running
- name: Make sure Docker is running
  service:
    name: docker
    state: started
  tags: docker
```

**3-3 Document your docker_container tasks configuration.**
**Is it really safe to deploy automatically every new image on the hub ? explain. What can I do to make it more secure?**
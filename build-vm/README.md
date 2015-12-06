###Vagrant VirtualBox VM set up instructions:

1. Download and install [VirtualBox](https://www.virtualbox.org/)
2. Download and install [Vagrant](http://www.vagrantup.com/)
3. Clone this repository.
4. Install vagrant-reload plugin by typing `vagrant plugin install vagrant-reload` in the terminal.
5. Navigate to this directory and run `vagrant up` on terminal to set up the vm. This would do following:
  * Download the virtual box image
  * Create virtual machine using this image
  * Launch VM in GUI mode
  * Install java 1.7 
  * Install and configure eclipse 3.7.2 with ConcernMapper and ConcernReCS plugins.
  * Configure VM by removing unused sidebar icons and placing important project related files on the desktop.
  * Setup a sample project to test ConcernReCS tool.

####Acknowledgements:
  * Used vagrant virtual box image of [trusty32 by chrisvire](https://vagrantcloud.com/chrisvire/boxes/trusty32)
  * [https://www.gaggl.com/2013/06/quick-manual-eclipse-install-on-ubuntu/](https://www.gaggl.com/2013/06/quick-manual-eclipse-install-on-ubuntu/)
  * [https://help.ubuntu.com/community/UnityLaunchersAndDesktopFiles](https://help.ubuntu.com/community/UnityLaunchersAndDesktopFiles)

####Notes:
  * Please avoid using the VM till the complete installation is done.
  * Use the following credentials if prompted for:
    * username - vagrant
    * password - vagrant
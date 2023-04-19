<?php

namespace templates\php;

class Response
{
    private $id;
    private $username;
    private $email;
    private $password;
    private $firstContact;
    private $arrivalTime;

    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param mixed $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * @return mixed
     */
    public function getFirstContact()
    {
        return $this->firstContact;
    }

    /**
     * @param mixed $firstContact
     */
    public function setFirstContact($firstContact)
    {
        $this->firstContact = $firstContact;
    }

    /**
     * @return mixed
     */
    public function getArrivalTime()
    {
        return $this->arrivalTime;
    }

    /**
     * @param mixed $arrivalTime
     */
    public function setArrivalTime($arrivalTime)
    {
        $this->arrivalTime = $arrivalTime;
    }

    /**
     * @param $username
     * @param $email
     * @param $password
     */
    public function __construct($username, $email, $password, $firstContact, $arrivalTime)
    {
        $this->username = $username;
        $this->email = $email;
        $this->password = $password;
        $this->firstContact = $firstContact;
        $this->arrivalTime = $arrivalTime;
    }


    /**
     * @return mixed
     */
    public function getUsername()
    {
        return $this->username;
    }

    /**
     * @param mixed $username
     */
    public function setUsername($username)
    {
        $this->username = $username;
    }

    /**
     * @return mixed
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @param mixed $email
     */
    public function setEmail($email)
    {
        $this->email = $email;
    }

    /**
     * @return mixed
     */
    public function getPassword()
    {
        return $this->password;
    }

    /**
     * @param mixed $password
     */
    public function setPassword($password)
    {
        $this->password = $password;
    }


}
//$user1 = new User("Karl", "karl@gmail.com", 'karl123');

//echo $user1->getUsername();
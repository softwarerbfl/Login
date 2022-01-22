import React, { useState, } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';


const style = { margin: '10px 0', border: 0, background: 'skyblue', padding: '3.5px', cursor: 'pointer' };

function SignPage() {
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")
  const [ConfirmPassword, setConfirmPassword] = useState("")
  const [name, setName] = useState("")
  const [birth, setBirth] = useState("")
  const [major, setMajor] = useState("")
  const [hobby, setHobby] = useState("")
  const [Num, setNum] = useState(0) // 중복확인을 했는지 체크하는 용도인 변수

  let navigate = useNavigate()

  const onEmailHandler = (event) => {
    setEmail(event.currentTarget.value)
  }

  const onPasswordHandler = (event) => {
    setPassword(event.currentTarget.value)
  }

  const onConfirmPasswordHandler = (event) => {
    setConfirmPassword(event.currentTarget.value)
  }

  const onNameHandler = (event) => {
    setName(event.currentTarget.value)
  }

  const onBirthHandler = (event) => {
    setBirth(event.currentTarget.value)
  }

  const onMajorHandler = (event) => {
    setMajor(event.currentTarget.value)
  }

  const onHobbyHandler = (event) => {
    setHobby(event.currentTarget.value)
  }

  // Email 중복확인을 하는 함수(Onclick)
  const checkEmail = (event) => {
    event.preventDefault();

    axios.post('/api/check/email', {email: email})
        .then((response) => {
          if (response.data === true) {
            setNum(1)
            alert('사용가능한 Email입니다.');
          } else {
            setNum(2)
            alert('이미 사용중인 Email입니다.');
          }
        })
        .catch((error) => console.log(error))
  }

  const OnSignSubmitHandler = (event) => {
    event.preventDefault();

    if (Num === 0) {
      alert('Email 중복확인을 하세요.')
    } else if (Num === 2) {
      alert('이미 사용중인 Email입니다.')
      return
    }

    password !== ConfirmPassword && alert("비밀번호가 서로 다릅니다.")

    if (email === '' || password === '' || ConfirmPassword ==='' || name === '' || birth === '' || major === '' || hobby === '') {
      alert('입력칸을 다 채우세요.')
    }

    // 서버에 사용자가 입력한 데이터 전송 후 회원가입이 완료되면 login하라는 경고창을 띄우고 login 페이지로 이동
    axios.post("/api/users/create", {
      email: email, password: password, name: name, birth: birth, major: major, hobby: hobby
    })
        .then((response) => {
          if (response.statusText === 'OK') {
            alert('회원가입이 완료되었습니다. 다시 로그인해주세요.')
            navigate('/')
          } else {
            alert('회원가입에 실패했습니다.')
          }
        })
        .catch((error) => console.log(error))
  }

  return (
      <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', width: '100%', height: '100vh' }}>
        <form style={{ display: 'flex', flexDirection: 'column' }} onSubmit={OnSignSubmitHandler}>
          <h3>Sign-in</h3><br />

          <input type="email" value={email} onChange={onEmailHandler} placeholder='Email' autoFocus />

          <button style={style} onClick={checkEmail}>중복확인</button>

          <input type="password" value={password} onChange={onPasswordHandler} placeholder='Password' /><br />

          <input type="password" value={ConfirmPassword} onChange={onConfirmPasswordHandler} placeholder='Confrim Password' /><br />

          <input type="text" value={name} onChange={onNameHandler} placeholder='name' /><br />

          <input type="date" value={birth} onChange={onBirthHandler} placeholder='birth' /><br />

          <input type="text" value={major} onChange={onMajorHandler} placeholder='major' /><br />

          <input type="text" value={hobby} onChange={onHobbyHandler} placeholder='hobby' /><br />

          <button type='submit' style={style}>회원가입 완료</button>
        </form>
      </div>
  )
}

export default SignPage
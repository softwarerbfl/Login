import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import MyPage from './MyPage'


function LoginPage() {
  const [isLogin, setIsLogin] = useState(false)
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")
  const [data, setData] = useState([])

  const onEmailHandler = (event) => {
    setEmail(event.currentTarget.value)
  }

  const onPasswordHandler = (event) => {
    setPassword(event.currentTarget.value)
  }

  const onLoginSubmitHandler = (event) => {
    event.preventDefault();

    if (email === '') {
      alert('Email을 입력하세요.')
      return
    }

    if (password === '') {
      alert('Password를 입력하세요.')
      return
    }

    // 사용자에게 받은 정보를 서버에게 보내고 로그인 성공 시 myPage 화면으로 이동
    axios.post('/api/login', { email: email, password: password })
        .then((response) => {
          if (response.statusText === 'OK') {
            setData(response.data)
            setIsLogin(true)
            alert('로그인에 성공했습니다.');
          } else {
            alert('Email과 PW를 다시 확인해주세요.')
          }
        })
        .catch((error) => console.log(error))
  }

  return (
      <div>
        {!isLogin ?
            <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', width: '100%', height: '100vh' }}>
              <form style={{ display: 'flex', flexDirection: 'column' }} onSubmit={onLoginSubmitHandler}>
                <h3>Welcome to Gondew Login-App</h3><br /><br /><br /><br />

                <label>Email</label>
                <input type="email" value={email} onChange={onEmailHandler} autoFocus />

                <label>Password</label>
                <input type="password" value={password} onChange={onPasswordHandler} /><br />

                <button type='submit' style={{
                  margin: '10px 0', background: 'skyblue',
                  border: 0, fontSize: '15px', padding: '6px', cursor: 'pointer'
                }}>로그인</button>
                <Link to='/sign'>
                  <button style={{ border: 0, fontSize: '15px', padding: '6px', width: '100%', cursor: 'pointer' }}>회원가입</button>
                </Link>
              </form>
            </div> : <MyPage data={data} />
        }
      </div>
  )
}

export default LoginPage;
import React from 'react'
// import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';


function MyPage( {all} ) {
    console.log(all)
    // const [Infos, setInfos] = useState([]);

    // 사용자의 이메일 데이터를 이용해 화면에 띄우고자 하는 사용자 데이터를 가져온다.
    // useEffect( () => {
    //   axios.post('', {email: email})
    //     .then(response) => {
    //         if (response.statusText === 'ok') {
    //             alert('사용가능한 Email입니다.');
    //             setInfos(response.data)
    //     })
    //     .catch((error) => console.log(error))
    // }, []);
    let navigate = useNavigate()

    const goHome = () => {
        navigate('/')
    }

    return (
        <div style={{ position:'absolute', width:'100px', height:'100px', top:'18%', left:'40%' }}>
            <h2>MyPage</h2><br /><br />

            <h3>이름</h3>
            <p>{all.name}</p>
            <h3>학과</h3>
            <p>{all.major}</p>
            <h3>취미</h3>
            <p>{all.hobby}</p>

            {/*<Link to='/'>*/}
            {/*    <button*/}
            {/*        style={{ border: 0, background: 'darkgray', cursor: 'pointer', color: 'white', width: '100%', padding: '10px 15px', margin: '50px 180px'}}*/}
            {/*    >로그아웃</button>*/}
            {/*</Link>*/}
            navigate('/')
            <button
                style={{ border: 0, background: 'darkgray', cursor: 'pointer', color: 'white', width: '100%', padding: '10px 15px', margin: '50px 180px'}}
                onClick={goHome}
            >로그아웃</button>
        </div>
    )
}

export default MyPage;
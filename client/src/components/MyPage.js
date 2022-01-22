import React from 'react'


function MyPage( {data} ) {

    return (
        <div style={{ position:'absolute', width:'100px', height:'100px', top:'18%', left:'40%' }}>
            <h2>MyPage</h2><br /><br />

            <h3>이름</h3>
            <p>{data.name}</p>
            <h3>학과</h3>
            <p>{data.major}</p>
            <h3>취미</h3>
            <p>{data.hobby}</p>
        </div>
    )
}

export default MyPage;
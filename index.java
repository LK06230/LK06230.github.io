// 간단한 React 컴포넌트 예시

import React, { useState } from 'react';

function App() {
  const [userId, setUserId] = useState('');
  const [role, setRole] = useState(null);
  const [quests, setQuests] = useState([]);
  const [supportingQuests, setSupportingQuests] = useState([]);

  const login = () => {
    if(userId.trim() !== '') {
      alert(`${userId}님 로그인 성공! 역할을 선택하세요.`);
    }
  };

  const createQuest = () => {
    const questName = prompt('새 퀘스트 이름을 입력하세요.');
    if(questName) {
      setQuests([...quests, questName]);
    }
  };

  const supportQuest = () => {
    const questName = prompt('지원할 퀘스트 이름을 입력하세요.');
    if(questName) {
      setSupportingQuests([...supportingQuests, questName]);
    }
  };

  if(!userId) {
    return (
      <div>
        <h2>로그인</h2>
        <input placeholder="아이디 입력" value={userId} onChange={e => setUserId(e.target.value)} />
        <button onClick={login}>로그인</button>
      </div>
    );
  }

  if(!role) {
    return (
      <div>
        <h2>역할 선택</h2>
        <button onClick={() => setRole('maker')}>메이커</button>
        <button onClick={() => setRole('solver')}>솔버</button>
      </div>
    )
  }

  return (
    <div>
      <h2>{userId}님 - {role === 'maker' ? '메이커 페이지' : '솔버 페이지'}</h2>
      {role === 'maker' ? (
        <div>
          <button onClick={createQuest}>퀘스트 생성</button>
          <h3>내 퀘스트 목록</h3>
          <ul>{quests.map((q,i) => <li key={i}>{q}</li>)}</ul>
        </div>
      ) : (
        <div>
          <button onClick={supportQuest}>퀘스트 지원</button>
          <h3>지원한 퀘스트 목록</h3>
          <ul>{supportingQuests.map((q,i) => <li key={i}>{q}</li>)}</ul>
        </div>
      )}
    </div>
  );
}

export default App;
